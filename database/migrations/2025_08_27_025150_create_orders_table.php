<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('orders', function (Blueprint $table) {
            $table->uuid('id')->primary();
            $table->float('shipping_cost');
            $table->float('discount_amount');
            $table->string('cupom_code', 80);
            $table->float('total_price');
            $table->string('order_code');
            $table->string('payment_method', 30);
            $table->datetime('paid_at')->nullable();
            $table->text('id_transition')->nullable();
            $table->string('shipping_method', 30);
            $table->string('tracking_code', 30);
            $table->boolean('status');
            $table->timestamps();

            $table->foreignUuid('user_id')->constrained('users');
        });

        Schema::create('order_product', function (Blueprint $table) {
            $table->uuid('id')->primary();
            $table->float('price_unit');
            $table->integer('quantity');
            $table->float('subtotal');
            $table->timestamps();

            $table->foreignUuid('product_id')->constrained('products');
            $table->foreignUuid('order_id')->constrained('orders');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('order_product');
        Schema::dropIfExists('orders');
    }
};
