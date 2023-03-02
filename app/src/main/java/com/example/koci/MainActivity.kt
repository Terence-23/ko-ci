package com.example.koci

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.koci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var TAG = "Main activity"
    val dice: MutableList<Dice> = MutableList(0){ Dice(0,0)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addB.setOnClickListener{
            try {
                val d_count = binding.countE.text.toString().toInt()
                val w_count = binding.wallE.text.toString().toInt()

                dice.add(Dice(w_count, d_count))
                binding.DiceText.text = "${binding.DiceText.text}  ${d_count}D${w_count}"
            }
            catch(e: NumberFormatException){
                Log.e(TAG, "error during parsing of: " +
                    "${binding.countE.toString()} or ${binding.wallE.toString()}")
            }
        }
        binding.rollB.setOnClickListener{
            binding.ResultText.text = ""
            if (dice.size == 0){
                binding.ResultText.text = "Result will be shown here"
            }else {
                for (i in dice) {
                    val tmp_text = "D${i.walls} rolled: ${i.roll()}\n"
                    binding.ResultText.text = "${binding.ResultText.text}${tmp_text}"
                }
            }

            dice.clear()
            binding.DiceText.text = ""
        }

    }
}