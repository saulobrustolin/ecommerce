<?php

use Illuminate\Support\Facades\Route;
use Inertia\Inertia;

// pagina inicial
Route::get('/', function () {
    return Inertia::render('home');
})->name('home');

// institutional
Route::get('/about', function () {
    return Inertia::render('institutional/about');
})->name('about');

Route::get('/policy/devolution', function () {
    return Inertia::render('institutional/policy/devolution');
})->name('policy.devolution');

Route::get('/policy/cookies', function () {
    return Inertia::render('institutional/policy/cookies');
})->name('policy.cookies');

Route::get('/policy/legal', function () {
    return Inertia::render('institutional/policy/legal');
})->name('policy.legal');

Route::get('/policy/privacy', function () {
    return Inertia::render('institutional/policy/privacy');
})->name('policy.privacy');

Route::get('/faq', function () {
    return Inertia::render('institutional/faq');
})->name('faq');

Route::get('/contact', function () {
    return Inertia::render('institutional/contact');
})->name('contact');


// collections
Route::get('/collections/{name}', function ($name) {
    return Inertia::render('collections/index', [
        'name' => $name,
    ]);
})->name('collections');

// products
Route::get('/products/{slug}', function ($slug) {
    return Inertia::render('products/index', [
        'slug' => $slug,
    ]);
})->name('product');

Route::middleware(['auth', 'verified'])->group(function () {
    Route::get('dashboard', function () {
        return Inertia::render('dashboard');
    })->name('dashboard');

    // users
    Route::get('my-account', function () {
        return Inertia::render('users/my-account');
    })->name('my-account');

    Route::get('my-account/settings', function () {
        return Inertia::render('users/settings');
    })->name('my-account.settings');

    Route::get('my-account', function () {
        return Inertia::render('users/orders');
    })->name('my-account.orders');

    Route::get('my-account/favorites', function () {
        return Inertia::render('users/favorites');
    })->name('my-account.favorites');

    // pedidos
    Route::get('order/{number}', function ($number) {
        return Inertia::render('orders/checkout', [
            'number' => $number,
        ]);
    })->name('order');
});

require __DIR__.'/settings.php';
require __DIR__.'/auth.php';
