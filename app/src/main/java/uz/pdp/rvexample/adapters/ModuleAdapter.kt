package uz.pdp.rvexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.rvexample.databinding.ItemModuleBinding
import uz.pdp.rvexample.models.Module

class ModuleAdapter(
    var list: List<Module>,
    var onModuleItemClickListener: CourseAdapter.OnModuleItemClickListener
) : RecyclerView.Adapter<ModuleAdapter.Vh>() {

    inner class Vh(var moduleBinding: ItemModuleBinding) :
        RecyclerView.ViewHolder(moduleBinding.root) {

        fun onBind(module: Module) {
            moduleBinding.moduleName.text = module.name

            moduleBinding.card.setOnClickListener {
                onModuleItemClickListener.onItemModuleClick(module)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemModuleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}