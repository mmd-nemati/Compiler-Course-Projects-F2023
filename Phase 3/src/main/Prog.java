import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.random;
enum markets {
    USD,ETH,BNB, ADA, XRP,IRR,EUR,BTC
}
class Env extends Thread{
    static int tick = 1000;
    static float price = 1000;
    static float vol = 10000;
    private ArrayList<BTrade> trades ;
    static private int numCand =200; //how many candles maintain for each trade
    private ArrayList<String> markets ;
    int uniqueID;
    public float[] wallet;


    public Env(ArrayList<BTrade> _trades)
    {

        wallet = new float[8];
        for (int i=0; i<8;i++) wallet[i]=100; //for starting
        trades = _trades;
        markets = new ArrayList<String>();
        Collections.addAll(markets,"USDETH","USDBNB", "USDADA", "USDXRP","USDIRR",
                "USDEUR",
                "BTCETH",
                "BTCBNB",
                "BTCADA",
                "BTCXRP",
                "BTCIRR",
                "BTCEUR");
        uniqueID =0 ;

    }
        public void run()
    {
        //update the values of each trade at each tick
        System.out.println("updating values in each tick");
        for (BTrade t:trades) {
            if (!t.getClass().equals(Trade.class)) continue;
            Trade ct = (Trade)t;
            ct.Ask = Math.random()*price;
            ct.Bid = Math.random()*price;
            for (int i=0; i<numCand; i++) {
                ct.Time[i] = Long.toString(System.currentTimeMillis()-((numCand-i)*tick));
                ct.Open[i] = Math.random()*price;
                ct.Close[i] = Math.random()*price;
                ct.High[i] = Math.random()*price;
                ct.Low[i] = Math.random()*price;
                ct.Volume[i] = Math.random()*vol;
            }
            //we should also update some values of orders ?
            for (Order o:ct.orders)
            {
                if ((o.stoploss>ct.Bid) || (o.takeProfit>ct.Bid)) ct.close(o);
                if (!o.status)
                    if (o.type==0)
                    {
                        //buy
                        wallet[ct.getBaseMarket().ordinal()]-=ct.Bid*o.amount;
                        wallet[ct.getQuoteMarket().ordinal()]+=o.amount;
                    }else
                    {
                        //sell
                        wallet[ct.getBaseMarket().ordinal()]-=o.amount;
                        wallet[ct.getQuoteMarket().ordinal()]+=ct.Bid*o.amount;

                    }
            }
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public boolean Connect(String user,String pass){
        return true;
    }

    public BTrade Observe(String submarket)
    {
        BTrade t;
        if (markets.contains(submarket))
            t = new Trade(submarket,uniqueID);
        else t = new BTrade(submarket,uniqueID);
        uniqueID ++;
        trades.add(t);
        return t;
    }
    public void onInit(BTrade t)
    {
        //based on t.id call the appropriate onInit
        switch (t.id) {
            case 0:
                onInit0();
            case 1:
                onInit1();
            //todo add more cases
        }


    }
    public void onStart(BTrade t)
    {
        //based on t.id call the appropriate onInit
        switch (t.id) {
            case 0:
                onStart0();
            case 1:
                onStart1();
            //todo add more cases
        }
    }

    private void onInit0(){System.out.println("Trade 0 onInit");}//todo for index0
    private void onStart0(){System.out.println("Trade 0 onStart");}//todo for index0
    private void onInit1(){System.out.println("Trade 1 onInit");}//todo for index1
    private void onStart1(){System.out.println("Trade 1 onStart");}//todo for index1

    public void RefreshRate(BTrade t){}
    public void terminate(BTrade t)
    {
        trades.remove(t);
    }

}
class BTrade {
    String subMarket;
    int id;
    public BTrade(String s, int _id)
    {
        subMarket = s;
        id = _id;
    }
}
class Trade extends BTrade
{
    double Ask;
    double Bid;
    String[] Time;
    double[] Open;
    double[] Close;
    double[] High;
    double[] Low;
    double[] Volume;
    public ArrayList<Order> orders;
    static private int numCand =200;

    public Trade(String s, int id) {
        super(s, id);
        orders = new ArrayList<Order>();
        Time = new String[numCand];
        Open = new double[numCand];
        Close = new double[numCand];
        High = new double[numCand];
        Low = new double[numCand];
        Volume = new double[numCand];
    }

    public Candle[] getCandle(int reqIndex)
    {
        reqIndex =Math.min(reqIndex,numCand);
        Candle[] c = new Candle[reqIndex];

        for (int i=0; i<reqIndex; i++) {
            c[i] = new Candle(Time[numCand-reqIndex+i], Open[numCand-reqIndex+i],Close[numCand-reqIndex+i],High[numCand-reqIndex+i],Low[numCand-reqIndex+i],Volume[numCand-reqIndex+i]);
        }
        return c;
    }
    public Order makeOrder(int type, float stoploss,double takeProfit,int amount)
    {
        Order o = new Order(type,stoploss,takeProfit,amount);
        orders.add(o);
        return o;
    }
    public void open(Order o)
    {
        o.status = true;
    }
    public void close(Order o)
    {
        o.status = false;
        orders.remove(o);
    }
    public markets getQuoteMarket()
    {
        switch (subMarket.substring(3))
        {
            case "USD":return markets.USD;
            case "ETH":return markets.ETH;
            case "BNB":return markets.BNB;
            case "ADA":return markets.ADA;
            case "XRP":return markets.XRP;
            case "IRR":return markets.IRR;
            case "EUR":return markets.EUR;
            case "BTC":return markets.BTC;

        }
        return null;
    }
    public markets getBaseMarket()
    {
        switch (subMarket.substring(0,3))
        {
            case "USD":return markets.USD;
            case "ETH":return markets.ETH;
            case "BNB":return markets.BNB;
            case "ADA":return markets.ADA;
            case "XRP":return markets.XRP;
            case "IRR":return markets.IRR;
            case "EUR":return markets.EUR;
            case "BTC":return markets.BTC;

        }
        return null;
    }
}

class Candle
{
    String time;
    double open;
    double close;
    double high;
    double low;
    double volume;
    public Candle(String _time, double _open,double _close, double _high,double _low, double _v)
    {
        time = _time;
        open = _open;
        close = _close;
        high = _high;
        low = _low;
        volume = _v;
    }
}

class Order
{
    int type; //SELL=1, BUY=0
    float stoploss;
    double takeProfit;
    int amount;
    public boolean status;
    public Order(int _type, float _stoploss,double _takeProfit,int _amount)
    {

        type = _type;
        stoploss =_stoploss ;
        takeProfit = _takeProfit;
        amount = _amount;
        status = false ; // is closed
    }
 }

public class Prog
{
    public static void main(String[] args) {
        ArrayList<BTrade> trades = new ArrayList<BTrade>();

        Env env = new Env(trades);
        env.Connect("gholi","ghamar");
        env.Observe("USDETH");
        env.Observe("");
        env.Observe("IRRETH");

        env.start(); //variables are updated by the env

        for (BTrade t:trades)
                env.onInit(t);

        while (true && trades.size()!=0)
        {
            for (BTrade t:trades) {
                env.onStart(t);
            }
        }
    }
}

