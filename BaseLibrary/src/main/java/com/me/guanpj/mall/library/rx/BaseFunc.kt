package com.me.guanpj.mall.library.rx

import com.kotlin.base.common.ResultCode
import com.me.guanpj.mall.library.data.BaseResp
import rx.Observable
import rx.functions.Func1

class BaseFunc<T>:Func1<BaseResp<T>,Observable<T>>{
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status,t.message))
        }

        return Observable.just(t.data)
    }
}
