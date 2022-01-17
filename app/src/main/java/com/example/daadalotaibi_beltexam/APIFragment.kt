package com.example.daadalotaibi_beltexam

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daadalotaibi_beltexam.Api.APIClient
import com.example.daadalotaibi_beltexam.Api.APIInterface
import com.example.daadalotaibi_beltexam.Model.MyViewModel
import com.example.daadalotaibi_beltexam.Model.Universities

import com.example.daadalotaibi_beltexam.RVAdapter.RVAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class APIFragment : Fragment() {
    lateinit var rvSearch: RecyclerView
    lateinit var etUniversityName: EditText
    lateinit var btAPIBack: Button
    lateinit var btSearch: Button
    lateinit var searchAdapter: RVAdapter
    val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_a_p_i, container, false)


        btAPIBack=view.findViewById(R.id.btAPIBack)
        btSearch=view.findViewById(R.id.btSearch)
        etUniversityName = view.findViewById(R.id.etUnivercityName)
        rvSearch =view.findViewById(R.id.rvSearch)

        btAPIBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_APIFragment_to_homeFragment)
        }

        btSearch.setOnClickListener {
            var  search = etUniversityName.text.toString()
            if (search.isNotEmpty()) {
                getApi(search)
            } else {
                Toast.makeText(this.requireContext(), "Enter a name", Toast.LENGTH_SHORT).show()
            }
            etUniversityName.text.clear()
            hideKeyboard()
        }
        return view
    }

    private fun getApi(keyword: String) {
        //show progress Dialog
        val progressDialog = ProgressDialog(this.context)
        progressDialog.setMessage("Please wait")
        progressDialog.show()

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        val call: Call<Universities?>? = apiInterface!!.universityInfo("/search?name=$keyword")

        call?.enqueue(object : Callback<Universities?> {
            override fun onResponse(
                call: Call<Universities?>?,
                response: Response<Universities?>
            ) {
                progressDialog.dismiss()

                if(response.body()!=null)
                    setRV(response.body()!!)
            }
            override fun onFailure(call: Call<Universities?>, t: Throwable?) {
                Toast.makeText(requireContext(),"Unable to load data!", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
                call.cancel()
            }
        })
    }

    fun setRV(uni: Universities) {
        searchAdapter =RVAdapter(this ,uni)
        this.rvSearch.adapter = searchAdapter
        this.rvSearch.layoutManager = LinearLayoutManager(this.context)

    }


    fun hideKeyboard() {
        // Hide Keyboard
        val hideKeyboard = ContextCompat.getSystemService(requireContext(), InputMethodManager::class.java)
        hideKeyboard?.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }
}