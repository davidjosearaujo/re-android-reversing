// 编译指令 tsc main-service/behavior.ts ，记得去除编译产物中，这行以上的所有语句
// 返回空字符串就是不命中，其余自由发挥
var config_rules = {
    '0001': function (behaviors, bizInfo, features, quickLog) {
        if (features.activeTime > 2) {
            return 'Y';
        }
        return '';
    },
    '0002': function (behaviors, bizInfo, features, quickLog) {
        if (features.errTip && features.errTip.length > 0) {
            return 'Y';
        }
        return '';
    }
};

function endsWith(str, suffix) {
    return str && suffix && str.indexOf(suffix, str.length - suffix.length) !== -1;
}

var behavior = amc.isAndroid ? {
    computeFeature: function (behaviors, bizInfo, quickLog) {
        var _a;
        var features = {};
        if (!behaviors) {
            behaviors = [];
        }
        // 上一个模板name
        var lastPage = 'null';
        var activeTime = 0;
        for (var i = 0; i < behaviors.length; i++) {
            var behavior_1 = behaviors[i] || {};
            if (behavior_1.act_type === 'err') {
                if (!features['errTip']) {
                    features['errTip'] = [];
                }
                var errGuide = behavior_1.act_name || '';
                if (errGuide.length > 20) {
                    errGuide = errGuide.substring(0, 20);
                }
                features['errTip'].push((_a = {}, _a[lastPage] = errGuide, _a));
            }
            if (behavior_1.act_type === 'sys' && endsWith(behavior_1.act_name, '_onStop')) {
                if (lastPage === behavior_1.page_name) {
                    activeTime++;
                } else {
                    activeTime = 0;
                }
            }
            lastPage = !!behavior_1.page_name ? behavior_1.page_name : lastPage;
        }
        if (activeTime > 0) {
            features['activeTime'] = activeTime;
        }
        return features;
    },
    computeClassification: function (behaviors, bizInfo, features, quickLog) {
        var result = {};
        for (var key in config_rules) {
            if (config_rules.hasOwnProperty(key)) {
                try {
                    var rule_result = config_rules[key](behaviors || [], bizInfo || {}, features || {}, quickLog);
                    if (rule_result) {
                        result[key] = rule_result;
                    }
                } catch (e) {
                    // ignore
                }
            }
        }
        return result;
    },
    version: 1
} : {};

if (amc.fn.sdkGreaterThanOrEqual('10.8.53.4')) {
    setTimeout(function () {
        document.invoke('queryInfo', {
            queryKey: 'configJSONInfo',
            configKey: 'mainServiceTplInfo'
        }, function (info) {
            if (info && info.value) {
                setTimeout(function () {
                    document.invoke('tplupdate', {
                        tplInfoDict: {'QUICKPAY@main-service': info.value}
                    }, function (data) {
                    });
                }, 30);
            }
        });
    }, 1000);
}