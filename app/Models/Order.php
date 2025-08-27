<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Order extends Model
{
    /** @use HasFactory<\Database\Factories\OrderFactory> */
    use HasFactory, HasUuids;

    /**
     * Autofill for Order Model
     * 
     * @var array<string>
     */
    protected $fillable = [
        'shipping_cost', 
        'discount_amount', 
        'cupom_code', 
        'total_price', 
        'order_code', 
        'payment_method', 
        'paid_at', 
        'id_transition', 
        'shipping_method', 
        'tracking_code',
        'status',
        'user_id',
    ];
}
