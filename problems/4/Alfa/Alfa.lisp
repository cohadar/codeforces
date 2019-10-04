(let ((x (parse-integer (read-line))))
  (format T "~s~%" (if (and (equal (mod x 2) 0) (> x 2)) 'YES 'NO)))
