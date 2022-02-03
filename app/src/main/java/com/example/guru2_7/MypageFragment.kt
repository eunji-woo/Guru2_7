package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MypageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MypageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_mypage, null)
        val changeButton = view.findViewById<Button>(R.id.ChangePWbutton)
        val OutButton = view.findViewById<Button>(R.id.Outbutton)
        val nicknameTextView = view.findViewById<TextView>(R.id.nicknameTextView)
        val emailTextView = view.findViewById<TextView>(R.id.emailTextView)
        lateinit var dbManager: DBManager
        lateinit var sqlDB: SQLiteDatabase
        var pref = requireActivity().getSharedPreferences("user",0)
        var nickname = pref.getString("nickname", "default").toString()
        var email = pref.getString("email", "default").toString()

        nicknameTextView.text = nickname
        emailTextView.text = email

        changeButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                //비밀번호 변경창으로 이동
                val intent = Intent(context, ChangeActivity::class.java)
                startActivity(intent)
            }
        })

        OutButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                //탈퇴창으로 이동
                val intent = Intent(context, OutActivity::class.java)
                startActivity(intent)
            }
        })



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MypageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MypageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}