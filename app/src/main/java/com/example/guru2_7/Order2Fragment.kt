package com.example.guru2_7

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Order2Fragment : Fragment() {
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order2, null)

        // 이미지버튼 선언
        val acImageButton = view.findViewById<ImageButton>(R.id.acImageButton)
        val inImageButton = view.findViewById<ImageButton>(R.id.inImageButton)
        val mongImageButton = view.findViewById<ImageButton>(R.id.mongImageButton)
        val wfImageButton = view.findViewById<ImageButton>(R.id.wfImageButton)
        val kimImageButton = view.findViewById<ImageButton>(R.id.kimImageButton)
        val etcImageButton = view.findViewById<ImageButton>(R.id.etcImageButton)

        // 이미지 선언
        val acResultImage = view.findViewById<ImageView>(R.id.acResultImage)
        val inResultImage = view.findViewById<ImageView>(R.id.inResultImage)
        val kimResultImage = view.findViewById<ImageView>(R.id.kimResultImage)
        val mongResultImage = view.findViewById<ImageView>(R.id.mongResultImage)
        val wfResultImage = view.findViewById<ImageView>(R.id.wfResultImage)

        // 텍스트뷰 선언
        val acText = view.findViewById<TextView>(R.id.acTextView)
        val inText = view.findViewById<TextView>(R.id.inTextView)
        val mongText = view.findViewById<TextView>(R.id.mongTextView)
        val wfText = view.findViewById<TextView>(R.id.wfTextView)
        val kimText = view.findViewById<TextView>(R.id.kimTextView)
        val etcText = view.findViewById<TextView>(R.id.etcTextView)

        // 주문현황개수 변수를 활용하여 텍스트뷰에 출력
        acText.text = "주문현황개수 : $ac_count"
        inText.text = "주문현황개수 : $in_count"
        mongText.text = "주문현황개수 : $mong_count"
        wfText.text = "주문현황개수 : $wf_count"
        kimText.text = "주문현황개수 : $kim_count"
        etcText.text = "주문현황개수 : 0"

        // 배달중 아이콘 표시여부를 visibility처리로 조절
        if(acResult == 0){ acResultImage.visibility = View.GONE }
        else{ acResultImage.visibility = View.VISIBLE }

        if(inResult == 0){ inResultImage.visibility = View.GONE }
        else{ inResultImage.visibility = View.VISIBLE }

        if(mongResult == 0){ mongResultImage.visibility = View.GONE }
        else{ mongResultImage.visibility = View.VISIBLE }

        if(wfResult == 0){ wfResultImage.visibility = View.GONE }
        else{ wfResultImage.visibility = View.VISIBLE }

        if(kimResult == 0){ kimResultImage.visibility = View.GONE }
        else{ kimResultImage.visibility = View.VISIBLE }



        // 식당버튼을 클릭하면 각각의 식당 주문현황페이지로 intent된다
        // intent하면서 shop_name 값을 같이 보낸다
        acImageButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, Order1_Activity::class.java)
                intent.putExtra("shop_name", "ac")
                startActivity(intent)
            }
        })

        inImageButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, Order1_Activity::class.java)
                intent.putExtra("shop_name", "in")
                startActivity(intent)
            }
        })

        mongImageButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, Order1_Activity::class.java)
                intent.putExtra("shop_name", "mong")
                startActivity(intent)
            }
        })

        wfImageButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, Order1_Activity::class.java)
                intent.putExtra("shop_name", "wf")
                startActivity(intent)
            }
        })

        kimImageButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, Order1_Activity::class.java)
                intent.putExtra("shop_name", "kim")
                startActivity(intent)
            }
        })

        // 기타 식당은 입점준비중으로 안내창으로 intent된다
        etcImageButton.setOnClickListener(object :View.OnClickListener {
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
            Order2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}