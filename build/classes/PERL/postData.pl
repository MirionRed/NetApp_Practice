use LWP::UserAgent;

$domain = "http://labs.jamesooi.com/post-data.php";

$name = "Ng Lu Lu";
$id = "1234567890";
$car = "PPM1234";

my $ua = LWP::UserAgent->new;
$ua->agent("UEEN3123Demo/1.1");

my $res = $ua->post(
  $domain,
  [
    'name'=>$name,
    'idOrPassport'=>$idOrPassport,
    'car'=>$car,
  ],
);

if($res->is_success){
  print $res->content;
} else {
  print $res->status_line, "\n";
}
