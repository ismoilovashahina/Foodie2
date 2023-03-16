package com.example.foodie2.adapter

import Category
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.foodie2.databinding.ChildLayoutBinding
import com.example.foodie2.databinding.ParentItemBinding

class TypeFoodAdapter(
    var context: Context,
    var types: MutableMap<String, MutableList<Category>>,
    var type: String
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return 1
    }

    override fun getChildrenCount(p0: Int): Int {
        return types.get(type)!!.size
    }

    override fun getGroup(p0: Int): Any {
        return type
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return types.get(type)!!.get(p1).toString()
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val binding: ParentItemBinding
        if (p2 == null) {
            binding =
                ParentItemBinding.inflate(LayoutInflater.from(p3!!.context), p3, false)
        } else {
            binding = ParentItemBinding.bind(p2)
        }
        return binding.root
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val binding: ChildLayoutBinding
        if (p3 == null) {
            binding =
                ChildLayoutBinding.inflate(LayoutInflater.from(p4!!.context), p4, false)
        } else {
            binding = ChildLayoutBinding.bind(p3)
        }

        val category = types.get(type)!!.get(p1)
        binding.img.setImageResource(category.img)
        binding.name.text = category.name
        return binding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}