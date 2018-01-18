package com.example.svr.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.svr.swoosh.Utilities.EXTRA_LEAGUE
import com.example.svr.swoosh.R
import com.example.svr.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    var selectedSkill = ""

    fun onBeginnerClicked(view:View) {
        ballerBtn.isChecked = false

        selectedSkill = "beginner"
    }

    fun onBallerClicked(view:View) {
        beginnerBtn.isChecked = false

        selectedSkill = "baller"
    }

    fun onSkillFinishClicked(view:View) {
       if (selectedSkill != "") {
           val finishActivity = Intent(this, FinishActivity::class.java)
           finishActivity.putExtra(EXTRA_LEAGUE, league)
           finishActivity.putExtra(EXTRA_SKILL, selectedSkill)
           startActivity(finishActivity)
       } else {
           Toast.makeText(this, "Please select you skill level!", Toast.LENGTH_SHORT).show()
       }
    }
}


