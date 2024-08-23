Feature: Verify the /api/pro_subcategories endpoint, Melike

  Scenario: Verify the status code and response message when a GET request is sent to /api/pro_subcategories with valid authorization, Melike
    # Geçerli yetkilendirme ile /api/pro_subcategories endpoint'ine GET isteği gönderildiğinde status kodu ve response mesajını doğrula
    Given Get request is sent to api pro_subcategories endpoint with valid authorizationn
    # //Geçerli yetkilendirme ile /api/pro_subcategories endpoint'ine GET isteği gönderildi
    Then the status code should be 200, Melike
    # Status kodu 200 olmalı
    And the response message should be "Product Subcategories Listed Successfully.", Melike
    # Response mesajı "Product Subcategories Listed Successfully." olmalı
