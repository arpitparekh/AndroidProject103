package arpitparekh.verylateandroidbatch.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import arpitparekh.verylateandroidbatch.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {

    private ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Checkout.preload(getApplicationContext());

        binding.btnPay.setOnClickListener(view -> {

            Checkout checkout = new Checkout();

            checkout.setKeyID("rzp_test_6lbvAaMBT5lf7o");


            /**
             * Reference to current activity
             */
            final Activity activity = this;

            /**
             * Pass your payment options to the Razorpay Checkout as a JSONObject
             */
            try {
                JSONObject options = new JSONObject();

                options.put("name", "Dipti Rami");
                options.put("description", "Reference No. #123456");
                options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");

                options.put("theme.color", "#3399cc");
                options.put("currency", "INR");
                options.put("amount", "50000");//pass amount in currency subunits
                options.put("prefill.email", "gaurav.kumar@example.com");
                options.put("prefill.contact","9586447873");
                JSONObject retryObj = new JSONObject();
                retryObj.put("enabled", true);
                retryObj.put("max_count", 4);
                options.put("retry", retryObj);

                checkout.open(activity, options);

            } catch(Exception e) {
                Log.i("paymentError",e.toString());
            }

        });


    }

    @Override
    public void onPaymentSuccess(String s) {
        binding.tvPay.setText(s);
    }

    @Override
    public void onPaymentError(int i, String s) {
        binding.tvPay.setText(s);
    }
}