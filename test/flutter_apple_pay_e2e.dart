import 'package:flutter_apple_pay/flutter_apple_pay.dart';
import 'package:flutter_test/flutter_test.dart';
 import 'package:e2e/e2e.dart';

 void main() {
   E2EWidgetsFlutterBinding.ensureInitialized();

   testWidgets('Can get battery level', (WidgetTester tester) async {
     final FlutterApplePay flutterApplePay = FlutterApplePay();
     PaymentItem paymentItems = PaymentItem(label: 'Total', amount: 1.0);
     dynamic deviceToken = await FlutterApplePay.getStripeToken(
        countryCode: 'HK',
        currencyCode: 'HKD',
        paymentNetworks: [PaymentNetwork.visa, PaymentNetwork.mastercard],
        merchantIdentifier: 'merchant.com.example.gogogo',
        paymentItems: [paymentItems],
      );
     expect(deviceToken, isNotNull);
   });
 }