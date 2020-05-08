import org.junit.*;

import static org.junit.Assert.*;

public class DotTest {

    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РЅСѓР»РµРІСѓСЋ С‚РѕС‡РєСѓ.
     * **/
    @Test
    public void checkNullDot() {
        assertTrue(Dot.check(0, 0, 1));
    } //+


    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РѕР±Р»Р°СЃС‚СЊ РїРµСЂРІРѕР№ С‡РµС‚РІРµСЂС‚Рё.
     * **/
    @Test
    public void check1FalseDot() {
        assertFalse(Dot.check(0.005, 0.005, 2));
    }//+


    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РІРµСЂС…РЅРёСЋ РіСЂР°РЅРёС†Сѓ С‚СЂРµСѓРіРѕР»СЊРЅРёРєР°.
     * **/
    @Test
    public void check2HighTrue() {
        assertTrue(Dot.check(0, 2.5, 2.5));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ Р»РµРІСѓСЋ РіСЂР°РЅРёС†Сѓ С‚СЂРµСѓРіРѕР»СЊРЅРёРєР°.
     * **/
    @Test
    public void check2LeftTrue() {
        assertTrue(Dot.check(-0.5, 0, 1));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ СЃРµСЂРµРґРёРЅСѓ РіСЂР°РЅРёС†С‹ С‚СЂРµСѓРіРѕР»СЊРЅРёРєР°.
     * **/
    @Test
    public void check2MidTrue() {
        assertTrue(Dot.check(-0.5, 1, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РІ РѕР±Р»Р°СЃС‚СЊ С‚СЂРµСѓРіРѕР»СЊРЅРёРєР°.
     * **/
    @Test
    public void check2InTrue() {
        assertTrue(Dot.check(-0.4, 0.7, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° РІРµСЂС…РЅРёСЋ РіСЂР°РЅРёС†Сѓ С‚СЂРµСѓРіРѕР»СЊРЅРёРєР°.
     * **/
    @Test
    public void check2HighFalse() {
        assertFalse(Dot.check(0, 1.005, 1));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° СЃРµСЂРµРґРёРЅСѓ РіСЂР°РЅРёС†С‹ С‚СЂРµСѓРіРѕР»СЊРЅРёРєР°.
     * **/
    @Test
    public void check2MidFalse() {
        assertFalse(Dot.check(-0.5005, 1, 2));
    } //+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° Р»РµРІСѓСЋ РіСЂР°РЅРёС†Сѓ С‚СЂРµСѓРіРѕР»СЊРЅРёРєР°.
     * **/
    @Test
    public void check2LeftFalse() {
        assertFalse(Dot.check(-1.005, 0.005, 2));
    } //+



    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° СЃРµСЂРµРґРёРЅРЅСѓСЋ РіСЂР°РЅРёС†Сѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3MidTrue() {
        assertTrue(Dot.check(-1, -1, 1));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° РІРµСЂРЅСЋСЋ РіСЂР°РЅРёС†Сѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3HighTrue() {
        assertTrue(Dot.check(-2, 0, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° РЅРёР¶РЅСЋСЋ РіСЂР°РЅРёС†Сѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3LowTrue() {
        assertTrue(Dot.check(0, -1.5, 1.5));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РІ РѕР±Р»Р°СЃС‚СЊ  РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3InTrue() {
        assertTrue(Dot.check(-1.5, -1.5, 3));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° РЅРёР¶РЅСЋСЋ СЃРµСЂРµРґРёРЅСѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3LeftMidTrue() {
        assertTrue(Dot.check(-2, -1, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° Р»РµРІСѓСЋ СЃРµСЂРµРґРёРЅСѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3LowMidTrue() {
        assertTrue(Dot.check(-1, -2, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° РЅРёР¶РЅСЋСЋ СЃРµСЂРµРґРёРЅСѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3LowMidFalse() {
        assertFalse(Dot.check(-1, -2.001, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° РІРµСЂС…РЅСЋСЋ СЃРµСЂРµРґРёРЅСѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3HighFalse() {
        assertFalse(Dot.check(-2.5005, 0, 2.5));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° РЅРёР¶РЅСЋСЋ Р»РµРІСѓСЋ РіСЂР°РЅРёС†Сѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3LowLeftFalse() {
        assertFalse(Dot.check(-1.005, -1.005, 1));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° РЅРёР¶РЅСЋСЋ РїСЂР°РІСѓСЋ РіСЂР°РЅРёС†Сѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3LowRightFalse() {
        assertFalse(Dot.check(0, -2.005, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° Р»РµРІСѓСЋ РЅРёР¶РЅСЋСЋ СЃРµСЂРµРґРёРЅСѓ РєРІР°РґСЂР°С‚Р°.
     * **/
    @Test
    public void check3LeftMidFalse() {
        assertFalse(Dot.check(-2.001, -1, 2));
    }//+


    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° РїСЂР°РІСѓСЋ РіСЂР°РЅРёС†Сѓ РєСЂСѓРіР°.
     * **/
    @Test
    public void check4RightTrue() {
        assertTrue(Dot.check(1, 0, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° РЅРёР¶РЅСЋСЋ РіСЂР°РЅРёС†Сѓ РєСЂСѓРіР°.
     * **/
    @Test
    public void check4LowTrue() {
        assertTrue(Dot.check(0, -1, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РЅР° СЃРµСЂРµРґРёРЅСѓ РіСЂР°РЅРёС†С‹ РєСЂСѓРіР°.
     * **/
    @Test
    public void check4MidTrue() {
        assertTrue(Dot.check(0.7, -0.7, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїРѕРїР°РґР°РЅРёРµ РІ РѕР±Р»Р°СЃС‚СЊ РєСЂСѓРіР°.
     * **/
    @Test
    public void check4InTrue() {
        assertTrue(Dot.check(0.5, -0.5, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° СЃРµСЂРµРґРёРЅСѓ РіСЂР°РЅРёС†С‹  РєСЂСѓРіР°.
     * **/
    @Test
    public void check4MidFalse() {
        assertFalse(Dot.check(0.75, -0.7, 2));
    }//+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° РЅРёР¶РЅСЋСЋ РіСЂР°РЅРёС†Сѓ  РєСЂСѓРіР°.
     * **/
    @Test
    public void check4LowFalse() {
        assertFalse(Dot.check(0.001, -1.005, 2));
    } //+
    /**
     *   РџСЂРѕРІРµСЂСЏРµС‚ РїСЂРѕРјР°С… Р·Р° РїСЂР°РІСѓСЋ РіСЂР°РЅРёС†Сѓ  РєСЂСѓРіР°.
     * **/
    @Test
    public void check4RightFalse() {
        assertFalse(Dot.check(0.5001, 0, 1));
    } //+


}
