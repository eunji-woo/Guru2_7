package com.example.guru2_7

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ShopFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_shop, null)

        // 버튼 선언
        val acButton = view.findViewById<ImageButton>(R.id.acButton)
        val inButton = view.findViewById<ImageButton>(R.id.inButton)
        val kimButton = view.findViewById<ImageButton>(R.id.kimButton)
        val mongButton = view.findViewById<ImageButton>(R.id.mongButton)
        val wfButton = view.findViewById<ImageButton>(R.id.wfButton)
        val etcButton = view.findViewById<ImageButton>(R.id.etcButton)


        // 식당버튼을 클릭하면 각각 식당의 주문페이지로 intent된다
        // intent하면서 shop_name(식당이름)값을 같이 보낸다
        acButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, acActivity::class.java)
                intent.putExtra("shop_name", "ac")
                startActivity(intent)
            }
        })

        inButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, inActivity::class.java)
//                intent.putExtra("shop_name", "in")
                startActivity(intent)
            }
        })

        kimButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, kimActivity::class.java)
//                intent.putExtra("shop_name", "kim")
                startActivity(intent)
            }
        })

        mongButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, mongActivity::class.java)
//                intent.putExtra("shop_name", "mong")
                startActivity(intent)
            }
        })

        wfButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, wfActivity::class.java)
//                intent.putExtra("shop_name", "wf")
                startActivity(intent)
            }
        })

        // 기타 식당은 입점준비중으로 안내창으로 intent된다
        etcButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, etcActivity::class.java)
                startActivity(intent)
            }
        })

        return view
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}