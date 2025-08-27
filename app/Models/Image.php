<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Image extends Model
{
    /** @use HasFactory<\Database\Factories\ImageFactory> */
    use HasFactory, HasUuids;

    /**
     * Autofill for Model Image
     * 
     * @var array<string>
     */
    protected $fillable = ['url', 'slug_id'];
}
