package com.example.svr.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.svr.swoosh.Model.Player
import com.example.svr.swoosh.R
import com.example.svr.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    var selectedSkill = ""

    fun onBeginnerClicked(view:View) {
        ballerBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClicked(view:View) {
        beginnerBtn.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishClicked(view:View) {
       if (selectedSkill != "") {
           val finishActivity = Intent(this, FinishActivity::class.java)
           finishActivity.putExtra(EXTRA_PLAYER, player)
           startActivity(finishActivity)
       } else {
           Toast.makeText(this, "Please select you skill level!", Toast.LENGTH_SHORT).show()
       }
    }
}


