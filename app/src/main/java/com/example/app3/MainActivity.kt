package com.example.app3
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.app3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var  Value:Number =0;
    //    private var viewModel: TwoWayViewModel? = TwoWayViewModel()
    var click = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
       binding.apply {
           val ids:List<Button> = listOf<Button>(one,two,three,four,five,six,seven,eight,nine,zero,dot,equal,C,mode,multiply,minus,operator1,divide,plus)

           for(id in ids){
               showNumber.text =""
            id.setOnClickListener {
                click(it)
            }
           }
       }
    }

    private fun click(it: View?) {
        var next:Int;
        var temp:String ="";
        binding.apply {
            val valueButton:Int = when(it){
                one -> {one.text.toString().toInt()}
                two->  {two.text.toString().toInt()}
                three->{three.text.toString().toInt()}
                four->{four.text.toString().toInt()}
                five->{five.text.toString().toInt()}
                six->{six.text.toString().toInt()}
                seven->{seven.text.toString().toInt()}
                eight->{eight.text.toString().toInt()}
                nine->{nine.text.toString().toInt()}
                dot->{dot.text.toString().toInt()}
                plus->funPlus(temp)
                else->{zero.text.toString().toInt()}
            }
            next =valueButton
            temp = next.toString()+""+showNumber.text
            showNumber.text = temp
    }
  }
    private fun funPlus(temp:String): Int {
        val plus = binding.plus.text.toString().toInt() + temp.toInt()
        return plus;
    }
}