package pic.poc.archexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pic.poc.archexample.databinding.ActivityMainBinding
import pic.poc.archexample.mvc.MvcActivity
import pic.poc.archexample.mvp.MvpActivity
import pic.poc.archexample.mvvm.MvvmActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnMvc.setOnClickListener { startActivity(Intent(this, MvcActivity::class.java)) }
        binding.btnMvp.setOnClickListener { startActivity(Intent(this, MvpActivity::class.java)) }
        binding.btnMvvm.setOnClickListener { startActivity(Intent(this, MvvmActivity::class.java)) }
    }
}