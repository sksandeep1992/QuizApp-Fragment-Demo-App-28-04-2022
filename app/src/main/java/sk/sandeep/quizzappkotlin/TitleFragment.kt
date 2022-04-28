package sk.sandeep.quizzappkotlin

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import sk.sandeep.quizzappkotlin.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false
        )

        binding.playButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(TitleFragmentDirections.actionTitleFragment4ToGameFragment())
        }
       /* binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment4_to_gameFragment)
        }*/

       /* binding.rulesButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment4_to_rulesFragment)
        }

        binding.aboutButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment4_to_aboutFragment)
        }*/


        //Report that this fragment would like to participate in populating the
        // options menu by receiving a call to onCreateOptionsMenu and related methods.
        setHasOptionsMenu(true)

        return binding.root
    }

    //Add menu to title fragment
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    // to set action on menu clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}