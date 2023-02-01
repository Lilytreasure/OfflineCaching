package com.example.datacach.features.quoteslist
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.datacach.data.QuotesList
import com.example.datacach.databinding.QuotesItemsBinding

class QuotesAdapter :ListAdapter<QuotesList,QuotesAdapter.QuotesViewHolder>(QuotesListComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val binding=QuotesItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuotesViewHolder(binding)
    }



    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val currentItem=getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }

    }



    //Quotes viewHolder


    class QuotesViewHolder(private val binding:QuotesItemsBinding ):
    RecyclerView.ViewHolder(binding.root){
        fun bind(quotesList: QuotesList){
            binding.apply {
                textQuote.text=quotesList.text
                textAuthor.text=quotesList.author

            }

        }


    }


    //Quotes list Comparator
    //Checking the similarity of the items -Difference between old and new data set

   class QuotesListComparator: DiffUtil.ItemCallback<QuotesList>(){
       override fun areItemsTheSame(oldItem: QuotesList, newItem: QuotesList)=
           oldItem.text == newItem.text

           override fun areContentsTheSame(oldItem: QuotesList, newItem: QuotesList)=
               oldItem==newItem

       }


}