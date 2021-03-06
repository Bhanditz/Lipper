package com.fallllllll.lipperwithkotlin.data.network.model.impl

import com.fallllllll.lipperwithkotlin.core.constants.PAGE_COUNT
import com.fallllllll.lipperwithkotlin.data.databean.ShotBean
import com.fallllllll.lipperwithkotlin.data.databean.UserLikesBean
import com.fallllllll.lipperwithkotlin.data.network.model.DribbbleModel
import com.fallllllll.lipperwithkotlin.data.network.service.DribbbleService
import com.fallllllll.lipperwithkotlin.data.network.service.DribbbleServiceHttpMethods
import io.reactivex.Flowable

/**
 * Created by fall on 2017/6/2/002.
 * GitHub :  https://github.com/348476129/LipperWithKotlin
 */
class DribbbleModelImpl private constructor(private val dribbbleService: DribbbleService) : DribbbleModel {



    companion object {

        val instance: DribbbleModelImpl by lazy { DribbbleModelImpl(DribbbleServiceHttpMethods().service) }
    }


    override fun getShots(list: String, timeFrame: String, sort: String, page: String) = dribbbleService.getShots(list, timeFrame, sort, page, PAGE_COUNT.toString())
    override fun getUserInfo(token: String) = dribbbleService.getUserInfo("Bearer $token")
    override fun getUserLikes(userId: String): Flowable<List<UserLikesBean>> = dribbbleService.getUserLikes(userId)
    override fun likeAShot(shotsId: String) = dribbbleService.likeAShot(shotsId)
    override fun unlikeAShot(shotsId: String) = dribbbleService.unlikeAShot(shotsId)
    override fun getUserFollowingShots(page: String)=dribbbleService.getUserFollowingShots(page, PAGE_COUNT.toString())
    override fun getUserShots(page: String)=dribbbleService.getUserShots(page, PAGE_COUNT.toString())
    override fun getShotById(shotId: String)=dribbbleService.getShotById(shotId)
}
