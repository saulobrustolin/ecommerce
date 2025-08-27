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
        Schema::create('adresses', function (Blueprint $table) {
            $table->uuid('id');
            $table->string('city', 60);
            $table->integer('number');
            $table->string('zipcode', 20);
            $table->string('street', 80);
            $table->string('state', 60);
            $table->longText('obs');
            $table->timestamps();

            $table->foreignUuid('user_id')->constrained('users');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('adresses');
    }
};
