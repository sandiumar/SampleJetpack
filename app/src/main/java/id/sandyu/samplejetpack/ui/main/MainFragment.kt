package id.sandyu.samplejetpack.ui.main


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main. fragment_main.*

import id.sandyu.samplejetpack.R


/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel : MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        //TODO: Use the ViewModel

        //Observe data on the ViewModel, exposed as a LiveData
        viewModel.data.observe(this, Observer{ data ->
            view?.findViewById<TextView>(R.id.message)?.text = data
        })

        fab_change.setOnClickListener{
            viewModel.data.value = "Ready to Start"
        }

        /*Action when txt_message is click */
        message.setOnClickListener{
            view?.let { Navigation.findNavController(it).navigate(R.id.about) }
        }
    }


}
