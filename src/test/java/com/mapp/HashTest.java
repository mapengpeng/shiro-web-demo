package com.mapp;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class HashTest {

    @Test
    public void test() {
        SimpleHash hash = new SimpleHash("SHA-256", "888888", "1a2b3c4k5j8f9d_?!", 2);

        System.out.println(hash.toHex());
    }
}
