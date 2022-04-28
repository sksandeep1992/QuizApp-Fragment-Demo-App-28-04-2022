package sk.sandeep.quizzappkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import sk.sandeep.quizzappkotlin.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    private lateinit var binding: FragmentGameOverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)

        // Add OnClick Handler for Try Again button
       /* binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_gameOverFragment_to_gameFragment)
        }*/

        binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(GameOverFragmentDirections.actionGameOverFragmentToGameFragment())
        }
        return binding.root
    }
}