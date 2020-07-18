package com.example.tdm2_td02_exo1_.ui.playVideo

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.tdm2_td02_exo1_.R
import kotlinx.android.synthetic.main.play_video_fragment.*


class PlayVideoFragment : Fragment() {

    companion object {
        fun newInstance() = PlayVideoFragment()
    }

    private lateinit var viewModel: PlayVideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.play_video_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlayVideoViewModel::class.java)
        val videoPath =
            "android.resource://" + requireActivity().packageName + "/" + viewModel.video
        val uri: Uri = Uri.parse(videoPath)
        video_view.setVideoURI(uri)
        val mediaController = MediaController(activity)
        video_view.setMediaController(mediaController)
        mediaController.setAnchorView(video_view)
        video_view.start()
    }

}
