<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Concerns\HasUuids;
use Illuminate\Database\Eloquent\Model;

class Slug extends Model
{
    /** @use HasFactory<\Database\Factories\SlugFactory> */
    use HasFactory, HasUuids;

    /**
     * Autofill for Slug Model
     * 
     * @var array<string>
     */
    protected $fillable = ['name', 'image'];
}
