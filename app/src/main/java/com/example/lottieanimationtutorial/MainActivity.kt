package com.example.lottieanimationtutorial

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lottieanimationtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    var isLiked:Boolean = false

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isLiked = false

        // 좋아요 버튼의 클릭 리스너를 달아준다
        binding.likebtn.setOnClickListener{

            // 좋아요 상태가 아닐때
            if(isLiked == false){
                // 애니메이션의 커스텀
                // Custom animation speed or duration.
                // 0f = 0퍼센트, 1f = 100퍼센트
                // ofFloat(시작지점, 종료지점).setDuration(지속시간ms) 1000 = 1초
                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1000)
                animator.addUpdateListener {
                    binding.likebtn.setProgress(it.getAnimatedValue() as Float)
                }
                animator.start()
                isLiked = true
            }else{ // 좋아요 상태일때
                val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(500)
                animator.addUpdateListener {
                    binding.likebtn.setProgress(it.getAnimatedValue() as Float)
                }
                animator.start()

                isLiked = false
            }
            Log.d(TAG, "MainActivity - onCreate() /좋아요 버튼이 클릭되었다.${isLiked}")

        }

    }
}