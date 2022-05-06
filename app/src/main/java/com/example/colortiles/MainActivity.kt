package com.example.colortiles

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.colortiles.databinding.ActivityMainBinding
import kotlin.random.Random

const val firstInd = 0
const val secondInd = 1
const val thirdInd = 2
const val foursInd = 3

class MainActivity : AppCompatActivity() {

    var colorArrayList = ArrayList<Int>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        generateTiles()
        initViews()
    }

    private fun initViews() {
        binding.tileOne.setImageResource(colorArrayList[firstInd])
        binding.tileTwo.setImageResource(colorArrayList[secondInd])
        binding.tileThree.setImageResource(colorArrayList[thirdInd])
        binding.tileFour.setImageResource(colorArrayList[foursInd])


        binding.tileOne.setOnClickListener {
            binding.tileOne.setImageResource(defineColor(firstInd))
            binding.tileTwo.setImageResource(defineColor(secondInd))
            binding.tileThree.setImageResource(defineColor(thirdInd))
            defineWin()
        }
        binding.tileTwo.setOnClickListener {
            binding.tileTwo.setImageResource(defineColor(secondInd))
            binding.tileOne.setImageResource(defineColor(firstInd))
            binding.tileFour.setImageResource(defineColor(foursInd))
            defineWin()
        }
        binding.tileThree.setOnClickListener {
            binding.tileThree.setImageResource(defineColor(thirdInd))
            binding.tileOne.setImageResource(defineColor(firstInd))
            binding.tileFour.setImageResource(defineColor(foursInd))
            defineWin()
        }
        binding.tileFour.setOnClickListener {
            binding.tileFour.setImageResource(defineColor(foursInd))
            binding.tileTwo.setImageResource(defineColor(secondInd))
            binding.tileThree.setImageResource(defineColor(thirdInd))
            defineWin()
        }
    }

    private fun defineColor(index: Int): Int {
        if (colorArrayList[index] == R.color.white) {
            colorArrayList[index] = R.color.black
        } else
            colorArrayList[index] = R.color.white
        return colorArrayList[index]
    }

    private fun generateTiles() {
        colorArrayList.add(R.color.white)
        colorArrayList.add(R.color.black)

        for (i in 0 until 2) {
            val rand = Random.nextInt(0, 2)
            if (rand == 0) {
                colorArrayList.add(R.color.black)
            } else
                colorArrayList.add(R.color.white)
        }

        colorArrayList.shuffle()
    }

    private fun defineWin() {
        var count = 0
        for (color in colorArrayList) {
            if (color == R.color.black)
                count++
        }
        if (count == 0 || count == 4) {
            Toast.makeText(this, "Вы победили", Toast.LENGTH_SHORT).show()
        }
    }
}