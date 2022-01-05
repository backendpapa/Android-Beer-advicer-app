package com.backendpapa.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBeer=findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener{
            val beerColor=findViewById<Spinner>(R.id.beer_color)
            val color=beerColor.selectedItem.toString()
            val beerList=getBeers(color)
            val beers=beerList.reduce{str,item->str+'\n'+item}
            val brands=findViewById<TextView>(R.id.brands)
            brands.text="$beers"
        }
    }

    fun getBeers(color: String):List<String>{
        return when (color){
            "Light"-> listOf("Jail Fale Ale","Larger Lite")
            "Amber"-> listOf("Jack Amber","Red Moose")
            "Brown"-> listOf("Brown Bear Beer","Bock Brownie")
            else -> listOf("Gout Stout","Dark Daniel")

        }
    }
}