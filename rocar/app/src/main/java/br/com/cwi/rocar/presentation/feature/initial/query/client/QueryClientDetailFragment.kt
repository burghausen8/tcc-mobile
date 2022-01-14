package br.com.cwi.rocar.presentation.feature.initial.query.client

import android.app.AlertDialog
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentQueryClientDetailBinding
import br.com.cwi.rocar.presentation.extension.toPhoneFormat
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import android.content.Intent
import android.content.ComponentName
import android.telephony.PhoneNumberUtils

var EXTRA_QUERY_CLIENT_ID = 0

class QueryClientDetailFragment() : Fragment() {

    private lateinit var binding: FragmentQueryClientDetailBinding

    private val viewModel: QueryClientViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQueryClientDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setupViewModel() {
        viewModel.clientsById.observe(viewLifecycleOwner) { client ->
            binding.tvNameValue.text = client.name
            binding.tvCpfValue.text = client.cpf
            binding.tvStreetValue.text = client.street
            binding.tvNumberValue.text = client.nHome.toString()
            binding.tvCityValue.text = client.city
            binding.tvPhoneValue.text = toPhoneFormat(client.phone)
        }
        viewModel.getClientById(EXTRA_QUERY_CLIENT_ID)

        binding.contentDelete.root.setOnClickListener {
            alertDelete()
        }

        binding.contentEdit.root.setOnClickListener {
            navigateToEditClient()
        }

        binding.ivCall.setOnClickListener {
            alertCall()
        }
    }

    private fun alertDelete() {
        val dialogBuilder = AlertDialog.Builder(binding.root.context)

        dialogBuilder.setMessage("Você realmente deseja excluir?")
            .setCancelable(false)
            .setPositiveButton("Excluir", DialogInterface.OnClickListener { dialog, id ->
                deleteClient()
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.show()
    }

    private fun deleteClient() {
        viewModel.deleteClient(EXTRA_QUERY_CLIENT_ID)

        Toast.makeText(binding.root.context, "Cliente excluido!", Toast.LENGTH_LONG).show()

        findNavController().navigate(
            R.id.queryClientFragment
        )
    }

    private fun alertCall() {
        val dialogBuilder = AlertDialog.Builder(binding.root.context)

        dialogBuilder.setMessage("Oque você deseja fazer?")
            .setCancelable(false)
            .setPositiveButton("Ligar", DialogInterface.OnClickListener { dialog, id ->
                callClient(binding.tvPhoneValue.text.toString())
            })
            .setNegativeButton("Whatsapp", DialogInterface.OnClickListener { dialog, id ->
                whatsappClient(binding.tvPhoneValue.text.toString())
            })

        val alert = dialogBuilder.create()
        alert.show()
    }

    private fun callClient(numeroContato: String) {
        val uri = Uri.parse("tel:$numeroContato")

        val intent = Intent(Intent.ACTION_DIAL, uri)

        startActivity(intent)
    }

    private fun whatsappClient(numeroContato: String) {
        val intent = Intent("android.intent.action.MAIN")

        intent.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")

        intent.putExtra(
            "jid",
            PhoneNumberUtils.stripSeparators("55" + numeroContato) + "@s.whatsapp.net"
        );

        startActivity(intent)
    }

    private fun navigateToEditClient() {
        findNavController().navigate(
            R.id.queryClientEditFragment
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }
}