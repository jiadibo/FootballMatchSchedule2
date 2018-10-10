package com.example.jiadibo.footballmatchschedule.views.match

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jiadibo.footballmatchschedule.R
import com.example.jiadibo.footballmatchschedule.model.Match
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_match_detail.*

class MatchDetailActivity : AppCompatActivity(), DetailView {
    override fun showHomeImage(url: String) {
        Picasso.get().load(url).into(badge_team1)
    }

    override fun showAwayImage(url: String) {
        Picasso.get().load(url).into(badge_team2)
    }

    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_detail)


        val match = intent.getParcelableExtra<Match>("MATCH_OBJECT")
        date_match.text = match.dateEvent
        team_1.text = match.strHomeTeam
        team_2.text = match.strAwayTeam
        skor_team1.text = match.intHomeScore
        skor_team2.text = match.intAwayScore
        goals1.text = match.strHomeGoalDetails
        goals2.text = match.strAwayGoalDetails
        shots1.text = match.intHomeShots
        shots2.text = match.intAwayShots
        gkeepr1.text = match.strHomeLineupGoalkeeper
        gkeepr2.text = match.strAwayLineupGoalkeeper
        defense1.text = match.strHomeLineupDefense
        defense2.text = match.strAwayLineupDefense
        midfield1.text = match.strHomeLineupMidfield
        midfield2.text = match.strAwayLineupMidfield
        forward1.text = match.strHomeLineupForward
        forward2.text = match.strAwayLineupForward
        subtitus1.text = match.strHomeLineupSubstitutes
        subtitus2.text = match.strAwayLineupSubstitutes


        presenter = DetailPresenter(this)
        presenter.getHomeImage(match.idHomeTeam.toString())
        presenter.getAwayImage(match.idAwayTeam.toString())
    }


}
