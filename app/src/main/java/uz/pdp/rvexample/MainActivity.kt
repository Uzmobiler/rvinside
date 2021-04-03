package uz.pdp.rvexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import uz.pdp.rvexample.adapters.CourseAdapter
import uz.pdp.rvexample.databinding.ActivityMainBinding
import uz.pdp.rvexample.models.Category
import uz.pdp.rvexample.models.Module

class MainActivity : AppCompatActivity() {

    lateinit var categoryList: ArrayList<Category>
    lateinit var binding: ActivityMainBinding
    lateinit var courseAdapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        courseAdapter = CourseAdapter(categoryList, object : CourseAdapter.OnAllItemClickListener {
            override fun onAllItemClick(list: List<Module>) {
                Toast.makeText(this@MainActivity, "$list", Toast.LENGTH_SHORT).show()
            }
        }, object : CourseAdapter.OnModuleItemClickListener {
            override fun onItemModuleClick(module: Module) {
                Toast.makeText(this@MainActivity, "$module", Toast.LENGTH_SHORT).show()
            }
        })
        binding.rv.adapter = courseAdapter
    }

    private fun loadData() {
        val moduleList1 = ArrayList<Module>()
        val moduleList2 = ArrayList<Module>()

        moduleList1.add(Module("Kotlin Basic", "Kotlin basic o'rgatiladi"))
        moduleList1.add(Module("Kotlin OOP", "Kotlin OOP o'rgatiladi"))
        moduleList1.add(Module("Kotlin Advanced", "Kotlin advanced o'rgatiladi"))
        moduleList2.add(Module("Swift Basic", "Swift basic o'rgatiladi"))
        moduleList2.add(Module("Swift OOP", "Swift OOP o'rgatiladi"))
        moduleList2.add(Module("Swift Advanced", "Swift advanced o'rgatiladi"))


        categoryList = ArrayList()
        categoryList.add(Category("Android Development", moduleList1))
        categoryList.add(Category("iOS Development", moduleList2))
    }
}