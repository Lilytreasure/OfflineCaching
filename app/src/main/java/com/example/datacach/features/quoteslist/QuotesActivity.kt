package com.example.datacach.features.quoteslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datacach.R
import com.example.datacach.databinding.QuotesActivityBinding
import com.example.datacach.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuotesActivity : AppCompatActivity() {


    //implementation off offline data caching in mvvm model
    //Dependency injection
    //Todo--Offline data caching
    //Todo--Refactor the layout and add like button functionalities
    //Todo --Populating common likes in Firebase
    //Todo --Fetch images from an api to show alongside the quotes holder
    //Todo --Search the fetched data

    //Reference to the viewModel
    private val viewModel: QuotesViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bind the view
        val binding = QuotesActivityBinding.inflate(layoutInflater)
        //if the default layout without bind was let data could still be seen
        //but changes to the views using views could not be made
        setContentView(binding.root)


        //setting up the Quotes adapter
        val quotesAdapter = QuotesAdapter()

        binding.apply {
            recyclerData.apply {

                adapter = quotesAdapter
                layoutManager = LinearLayoutManager(this@QuotesActivity)

            }

            viewModel.quotes.observe(this@QuotesActivity) { result ->
                quotesAdapter.submitList(result.data)
                //catch errors to prevent thea app from crashing and log errors to the user
                //add a  network manager to notify  the user when connection is lost
                // add a view to alert the user when connection is lost
                //Hide the connection notifier when connection resumes
                // add a progress bar that is dispatched when data is loaded

                //Displaying the progress bar and the Error message
                //Progress bar  and  will only be visible if we do not have cached data-
                // And when the result is null
                LoadProgress.isVisible =result is Resource.Loading && result.data.isNullOrEmpty()
                textError.isVisible =result is Resource.Error && result.data.isNullOrEmpty()
                textError.text=result.error?.localizedMessage

            }

        }





        //End of onCreate Method
    }





}



