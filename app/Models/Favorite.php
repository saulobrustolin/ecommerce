<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Favorite extends Model
{
    /** @use HasFactory<\Database\Factories\FavoriteFactory> */
    use HasFactory, HasUuids;

    /**
     * Autofill for Favorite Model
     * 
     * @var array<string>
     */
    protected $fillable = ['image_id', 'user_id'];
}
