package com.example.logonrmlocal.githubaac.ui.userprofile


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.logonrmlocal.githubaac.R
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_user_profile.*
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class UserProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.setupDagger()
        this.setupViewModel()
        this.setupView()
    }

    fun setupDagger(){
        AndroidSupportInjection.inject(this)
    }

    fun setupView() {
        searchButton.setOnClickListener {
            this.viewModel.getUser(userNameEditText.text.toString())
            this.viewModel.user.observe(this, Observer {
                userInfoTextView.text = it?.name
                Picasso.get().load(it?.avatarURL).into(userImageView)
            })
        }
    }

    fun setupViewModel() {

        this.viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(UserProfileViewModel::class.java)
    }


}
