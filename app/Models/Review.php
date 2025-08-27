<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Review extends Model
{
    /** @use HasFactory<\Database\Factories\ReviewFactory> */
    use HasFactory, HasUuids;

    /**
     * Autofill for Review Model
     * 
     * @var array<string>
     */
    protected $fillable = ['describe', 'star', 'user_id', 'image_id'];
}
