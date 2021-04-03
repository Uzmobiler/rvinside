package uz.pdp.rvexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.rvexample.databinding.ItemCourseBinding
import uz.pdp.rvexample.models.Category
import uz.pdp.rvexample.models.Module

class CourseAdapter(
    var list: List<Category>,
    var onAllItemClickListener: OnAllItemClickListener,
    var onModuleItemClickListener: OnModuleItemClickListener
) : RecyclerView.Adapter<CourseAdapter.Vh>() {

    inner class Vh(var courseBinding: ItemCourseBinding) :
        RecyclerView.ViewHolder(courseBinding.root) {

        fun onBind(category: Category) {
            courseBinding.categoryName.text = category.name

            courseBinding.allBtn.setOnClickListener {
                onAllItemClickListener.onAllItemClick(category.list)
            }

            val moduleAdapter = ModuleAdapter(category.list, onModuleItemClickListener)
            courseBinding.moduleRv.adapter = moduleAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCourseBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnAllItemClickListener {
        fun onAllItemClick(list: List<Module>)
    }

    interface OnModuleItemClickListener {
        fun onItemModuleClick(module: Module)
    }
}