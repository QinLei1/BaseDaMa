package com.xcs.news.baseo.api;

import com.xcs.news.baseo.entity.model_zcw.CPKaiJiangs;
import com.xcs.news.baseo.entity.model_zcw.CitysBean;
import com.xcs.news.baseo.entity.model_zcw.JingCai;
import com.xcs.news.baseo.entity.model_zcw.TouTiaoBean;
import com.xcs.news.baseo.entity.model_zcw.TouTiaoBeans;

import java.util.ArrayList;

//import retrofit2.http.GET;
//import retrofit2.http.Headers;
//import retrofit2.http.POST;
//import retrofit2.http.Query;
//import retrofit2.http.Url;
import rx.Observable;

/**
 * @author ChayChan
 * @description: 网络请求的service
 * @date 2017/6/18  19:28
 */

public interface ApiService {

    String GET_ARTICLE_LIST = "api/news/feed/v62/?refer=1&count=20&loc_mode=4&device_id=34960436458&iid=13136511752";
    String GET_COMMENT_LIST = "article/v2/tab_comments/";
    //http://is.snssdk.com
    //http://is.snssdk.com/api/news/feed/v54/?refer=1&count=20&min_behot_time=1498722625&last_refresh_sub_entrance_interval=1498724693&loc_mode=4&tt_from=pull（tab_tip） 新闻列表
    //http://is.snssdk.com/article/v2/tab_comments/?group_id=6436886053704958466&item_id=6436886053704958466&offset=30&count=20 评论
    //http://is.snssdk.com/2/article/information/v21/ 详情
//    @GET("http://m.zhcw.com/clienth5.do?transactionType=8021&pageSize=10&busiCode=300203&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getTouTiaoList(@Query("pageNo") int pageNo);
//
//    /**
//     * 首页banner轮播图片
//     */
//    @GET("clienth5.do?transactionType=8010&busiCode=300102&cache=yes&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getHomeBanner();
//
//    /**
//     * 头条banner轮播图片
//     */
//    @GET("clienth5.do?transactionType=8020&busiCode=300202&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getTouTiaoBanner();
//
//    /**
//     * 彩讯banner轮播图片
//     */
//    @GET("clienth5.do?transactionType=8020&busiCode=300204&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getCaixunBanner();
//
//    /**
//     * 彩讯列表
//     */
//    @GET("clienth5.do?transactionType=8021&pageSize=10&busiCode=300205&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getCaixunaoList(@Query("pageNo") int pageNo);
//
//    /**
//     * 公益banner轮播图片
//     */
//    @GET("clienth5.do?transactionType=8020&busiCode=300206&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getGongyiBanner();
//
//    /**
//     * 彩讯列表
//     */
//    @GET("clienth5.do?transactionType=8021&pageSize=10&busiCode=300207&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getGongyiList(@Query("pageNo") int pageNo);
//
//    /**
//     * 视频banner轮播图片
//     */
//    @GET("clienth5.do?transactionType=8020&busiCode=300208&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getVedioBanner();
//
//    /**
//     * 视频列表
//     */
//    @GET("clienth5.do?transactionType=8021&pageSize=10&busiCode=300209&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getVideoList(@Query("pageNo") int pageNo);
//
//    /**
//     * 政策列表
//     */
//    @GET("clienth5.do?transactionType=8021&pageSize=10&busiCode=300210&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getPoliceList(@Query("pageNo") int pageNo);
//
//    /**
//     * 足球资讯列表
//     */
//    @GET("http://m.159cai.com/discovery/news/football/index.json")
//    Observable<ArrayList<TouTiaoBean>> getFootballList();
//
//    /**
//     * 篮球资讯列表
//     */
//    @GET("http://m.159cai.com/discovery/news/basketball/index.json")
//    Observable<ArrayList<TouTiaoBean>> getBasketballList();
//
//    /**
//     * 数字彩--预测
//     */
//    @GET("http://m.159cai.com/discovery/news/szc/index.json")
//    Observable<ArrayList<TouTiaoBean>> getYuCeList();
//
//    /**
//     * 竞彩足球列表
//     */
//    @GET("http://m.159cai.com/discovery/forecast/jczq/index.json")
//    Observable<ArrayList<JingCai>> getJCFootball();
//
//    /**
//     * 竞彩篮球列表
//     */
//    @GET("http://m.159cai.com/discovery/forecast/jclq/index.json")
//    Observable<ArrayList<JingCai>> getJCBasketball();
//
//    /**
//     * 主页轮播下面的头条信息
//     */
//    @GET("clienth5.do?transactionType=8010&busiCode=300104&cache=yes&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getHomeTouTiao();
//
//    /**
//     * 首页双色球、福彩3d、七乐彩的最新一条开奖结果
//     */
//    @GET("clienth5.do?transactionType=8010&busiCode=300105&cache=yes&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getOneNewKaiJiang();
//
//    /**
//     * 按地区查看各个彩种最新一条开奖结果
//     */
//    @GET("clienth5.do?transactionType=300305&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getAreaOneNewKaiJiang(@Query("dqId") String dqId);
//
//    /**
//     * 获取彩票的地区
//     */
//    @GET("clienth5.do?transactionType=300304&src=0000100001%7C6000003060")
//    Observable<CitysBean> getAreas();
//
//    /**
//     * 全国的彩票开奖列表 FC_SSQ：双色球  FC_3D：福彩3D  FC_QLC：七乐彩
//     */
//    @GET("clienth5.do?transactionType=300301&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getKjNational(@Query("lottery") String lottery,@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 地区的开奖列表
//     */
//    @GET("clienth5.do?transactionType=300306&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getKjArea(@Query("czId") String czId,@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 双色球开奖列表
//     */
//    @GET("clienth5.do?lottery=FC_SSQ&transactionType=300301&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getSSQKaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 七乐彩开奖列表
//     */
//    @GET("clienth5.do?lottery=FC_QLC&transactionType=300301&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getQLCKaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 福彩3D开奖列表
//     */
//    @GET("clienth5.do?lottery=FC_3D&transactionType=300301&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getFC3DKaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 15选5开奖列表
//     */
//    @GET("clienth5.do?czId=256&transactionType=300306&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> get15X5KaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 东方6+1开奖列表
//     */
//    @GET("clienth5.do?czId=321&transactionType=300306&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getDF61KaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 快3开奖列表
//     */
//    @GET("clienth5.do?czId=563&transactionType=300306&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getKuai3KaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 时时彩开奖列表
//     */
//    @GET("clienth5.do?czId=572&transactionType=300306&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> getSSCKaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 安徽25选5
//     */
//    @GET("clienth5.do?czId=258&transactionType=300306&src=0000100001%7C6000003060")
//    Observable<CPKaiJiangs> get25x5KaiJiang(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
//
//    /**
//     * 分析列表
//     * lottery=FC_SSQ，lottery=FC_3D，lottery=FC_QLC
//     */
//    @GET("clienth5.do?transactionType=8050&busiCode=300501&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getCPAnalysis(@Query("lottery") String lottery);
//
//    /**
//     * 分析列表
//     * lottery=FC_SSQ，lottery=FC_3D，lottery=FC_QLC
//     */
//    @GET("clienth5.do?transactionType=8050&pageSize=10&busiCode=300502&src=0000100001%7C6000003060")
//    Observable<TouTiaoBeans> getCPAnalysis(@Query("lottery") String lottery,@Query("pageNo") int pageNo);

}

