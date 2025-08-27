<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Adress extends Model
{
    /** @use HasFactory<\Database\Factories\AdressFactory> */
    use HasFactory, HasUuids;

    /**
     * Autofill for Adress Model
     * 
     * @var array<string>
     */
    protected $fillable = ['city', 'state', 'obs', 'number', 'zipcode', 'street'];
}
