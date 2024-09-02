package com.example.app3
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.app3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
//    private var viewModel: TwoWayViewModel? = TwoWayViewModel()
    var click = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
          binding.View.setOnClickListener {
              if(click){
                  binding.apply {
                      View.setBackgroundColor(Color.GRAY)
                      text1.setTextColor(-0x1);
                      textTwo.setTextColor(-0x1)
                      textThree.setTextColor(-0x1)
                      text4.setTextColor(-0x1)
                  }
                  showBox();
                  click = false
              }else{
                  binding.apply {
                      View.setBackgroundColor(Color.BLACK)
                      text1.setTextColor(getColor(R.color.black));
                      textTwo.setTextColor(getColor(R.color.black))
                      textThree.setTextColor(getColor(R.color.black))
                      text4.setTextColor(getColor(R.color.black))
                  }
                  click = true
              }
        }
    }

    private fun showBox() {
           binding.apply {
               val clickableView:List<View> = listOf(text1,textTwo,textThree,text4);
               for (item in clickableView){
                   item.setOnClickListener { makeColor(it) }

               }
           }
    }

    private fun makeColor(view: View?) {
    if(!click){
        when(view){
            binding.text1->view.setBackgroundColor(Color.GREEN);
            binding.textTwo->view.setBackgroundColor(Color.RED);
            binding.textThree->view.setBackgroundColor(Color.YELLOW);
            binding.text4->view.setBackgroundColor(Color.BLUE);
        }
    }
    else{
        when(view){
            binding.text1->view.setBackgroundColor(Color.BLACK);
            binding.textTwo->view.setBackgroundColor(Color.BLACK);
            binding.textThree->view.setBackgroundColor(Color.BLACK);
            binding.text4->view.setBackgroundColor(Color.BLACK);
        }
    }
    }
}