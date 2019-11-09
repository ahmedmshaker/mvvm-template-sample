package ${PackageName}.presentation.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.articles.R
import ${PackageName}.presentation.viewmodel.${ViewModelName}
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_articles.*
import javax.inject.Inject


class ${FragmentName} : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    private lateinit var m${ViewModelName}: ${ViewModelName}



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.${layoutName}, container, false)
    }


    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenStarted {
            try {
          m${ViewModelName} =
                          ViewModelProviders.of(activity!!, viewModelFactory).get(${ViewModelName}::class.java)

            } finally {

            }
        }
    }




}
