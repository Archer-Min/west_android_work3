package com.example.work3_bilibili.data

import com.example.work3_bilibili.R

object DataSender {
    fun prepareUpData(): MutableList<UpInfo> {
        return mutableListOf(
            UpInfo(
                R.drawable.leina,
                "蕾娜",
                "第4卷男女主见面，彼此都对对方好感值拉满点，俩人都忍不住靠近对方，但是也在彼此靠近中发现自己和对方的不一样，所以5-6卷俩人也基本上围绕着这个问题展开了拉扯，拉扯中，辛发现，自己想要永远和蕾娜在一起，可是如果不改变自己的世界观价值观，那一定会伤害蕾娜，所以5-6卷他一直在挣扎着想要改变自己，可是战场上的残酷长期铸就出来的世界观并非轻易就能改变的，而他又不想让蕾娜见到自己无法快速做出改变的懦弱的自己，所以不愿意和蕾娜说出自己复杂的心事，蕾娜就难受：辛不信任我呜呜\uD83E\uDD79[哭惹R]，辛他和莱登说却不和我说\uD83E\uDD79，还在辛面前哇哇哭哭得可美了（有插画），辛有苦难言，终于在第六卷结尾危命时刻对蕾娜真情告白（伪）",
                R.drawable.leina86,
                100,
                80,
                20
            ),
            UpInfo(
                R.drawable.fulilian,
                "芙莉莲",
                "我觉得死去的白月光最好磕，不要复活梗，永远活在回忆里",
                R.drawable.zangsongdefulilian,
                200,
                90,
                88
            ),
            UpInfo(R.drawable.hu, "这是什么咬一口", "这是布偶的动态", R.drawable.sleep, 99, 7, 90),
            UpInfo(
                R.drawable.zhiting,
                "该账号已注销",
                "金宇硕（김우석、KIM WOO SEOK），1996年10月27日出生于韩国大田广域市，韩国流行乐男歌手、演员，男子演唱组合UP10TION成员、前男子演唱组合X1成员",
                R.drawable.jinyushuo,
                8,
                7,
                20
            ),
            UpInfo(R.drawable.ju, "哇哦橘橘", "这是哇哦橘橘的动态", R.drawable.dongtai1, 60, 80, 90),
            UpInfo(R.drawable.ma, "mama", "玫瑰花糖葫芦", R.drawable.wenhao, 70, 90, 100)
        )
    }
}