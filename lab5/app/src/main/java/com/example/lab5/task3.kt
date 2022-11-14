package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.net.URL

class task3 : AppCompatActivity() {

    var parsedData = mutableListOf<HashMap<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)

        val listView = findViewById<ListView>(R.id.list_view)
        val adapter = SimpleAdapter(
            this, parsedData, R.layout.list_val,
            arrayOf("key", "value"), intArrayOf(R.id.name_val, R.id.count_val)
        )
        listView.adapter = adapter

        Thread {
            try {
                val pullParser = XmlPullParserFactory.newInstance()
                val parser = pullParser.newPullParser()
                parser.setInput(URL("https://www.cbr.ru/scripts/XML_daily.asp").openStream(), null)

                var name = ""
                var value = ""
                var count = ""

                while (parser.eventType != XmlPullParser.END_DOCUMENT) {
                    if (parser.eventType == XmlPullParser.START_TAG) {
                        if (parser.name.equals("Nominal")) {
                            count = parser.nextText()
                        }
                        if (parser.name.equals("Name")) {
                            name = parser.nextText()
                        }
                        if (parser.name.equals("Value")) {
                            value = parser.nextText()
                        }
                    }
                    if (parser.eventType == XmlPullParser.END_TAG) {
                        if (parser.name.equals("Valute")) {
                            val key = count + " " + name
                            parsedData.add(hashMapOf("key" to key, "value" to value))
                        }
                    }
                    parser.next()
                }

            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: XmlPullParserException) {
                e.printStackTrace()
            }
            runOnUiThread{
                adapter.notifyDataSetChanged()
            }
        }.start()
    }
}