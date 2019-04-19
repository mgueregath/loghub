/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.migration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public abstract class InitData {

    private static List<InitData> initData = new ArrayList<>();
    public static Map<String, InitData> initDataHash = new HashMap<>();

    public InitData() {
        initData.add(this);
        initDataHash.put(getTargetClass().getCanonicalName(), this);
    }

    public static List<InitData> getInitData() {
        return initData;
    }

    public abstract Class getTargetClass();

    public abstract List<?> getData();

    public abstract void setData(List<Object> data);
}
