package com.example.tdm2_td02_exo1_.ui.termDictionary

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tdm2_td02_exo1_.R
import com.example.tdm2_td02_exo1_.ui.playVideo.PlayVideoViewModel
import kotlinx.android.synthetic.main.term_dictionary_fragment.*


class TermDictionaryFragment : Fragment() {

    companion object {
        fun newInstance() = TermDictionaryFragment()
    }

    private lateinit var viewModel: TermDictionaryViewModel
    private var soundPool: SoundPool? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.term_dictionary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TermDictionaryViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(TermDictionaryViewModel::class.java)
        val term = viewModel.term
        definition_title.text = term.word
        definition_view.text = term.definition
        term_image_view.setImageResource(term.image)

        //Create  sound pool
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(6)
            .setAudioAttributes(audioAttributes)
            .build()

        val sound = soundPool?.load(activity, term.audio, 1);

        //play sound on button click
        button_hear_prononciation.setOnClickListener {
            soundPool?.play(sound!!, 1F, 1F, 0, 0, 1F)//rate : vitesse
        }
        //play video on button click
        button_video.setOnClickListener {
            if(term.video == null){
                Toast.makeText(requireActivity(),"The video does not exist",Toast.LENGTH_SHORT).show()
            }else{
                PlayVideoViewModel.videoStatic = term.video
                val navController: NavController =
                    Navigation.findNavController(requireActivity(), R.id.navigation_fragment)
                navController.navigate(R.id.dictionaty_to_video_action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool?.release()
        soundPool = null
    }

}
