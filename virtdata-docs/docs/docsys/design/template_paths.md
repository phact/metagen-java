# Template Paths

Because the templating system is quite flexible, it can also mean
some clutter in the file system for new users. It may not be clear what
each type of file patter is for. This document should clarify that
both for new users and for implementors.

## file._extension

Any file which contains an extension with an underscore at the start is
considered a template file. Only these files will be evaluated dynamically
with mustache.

### Local Templates: `_._extension`

Any file with a base name of `_._extension` is considered a local template. That is, any other file with the same
extension will be wrapped within this template.

For example. A directory with files named
- `_._extension`
- `foo._extension`

will result in a virtual file `foo.extension` being visible on the file system. When this file is accessed,
the contents of `foo._extension` will be rendered into a
buffer, and then the contents of `_._extension` will be evaluated, using the result and view model of `_._extension`. The result will be cached as the content
of `foo.extension`

Local templates also wrap any file of the same extension.
That means that if a file named `bar.extension` were also in the directory, that accessing it would invoke the same
wrapping logic above.

Local templates only apply to files in the same directory
as the template.

## TODO: implement this ^^

### Parent Templates `__._extension`

While local templates only apply to files in the current directory,
parent templates apply to every file within their filesystem scope
of the same extension.

For example, with the structure:

- dir1
  - `__._extension`
  - dir2
    - dir3
      - foobarbaz.extension
      
Accessing file `dir1/dir2/dir3/foobarbaz.extension` would cause
the template wrapping logic to apply with the contents of
`foobarbaz.extension` and `__._extension`. These layers of content
would be wrapped together like this:

- `/dir1/__._extension`
  - `/dir1/dir2/di43/foobarbaz.extension`

## Layering

These templating mechanisms work together. For example, consider this directory structure:

- dir1
  - `__._DOG`
  - dir2
    - `__._DOG`
    - `_._DOG`
    - dir3
      - `_._DOG`
      - `CAT._DOG`
          
Access to the file `/dir1/dir2/dir3/CAT.DOG` would
result in template nesting of

1. `/dir1/__._DOG`
2. `/dir1/dir2__._DOG`
2. `/dir1/dir2/dir3/_._DOG`
3. `/dir1/dir2/dir3/CAT._DOG`

Notice that `/dir1/dir2/_._DOG` is not included, while `/dir1/dir2/__._DOG` _is_.

## Logical and Physical Views

Since users may not want to see all the template
scaffolding needed to create a rich view, yet they
might want topical views of content, there are two
different ways of looking at the file system.

The logical view is the one which only shows the files
which are meant to be user-facing. This is provided
by default in the view model. These views do _not_ include files which are templates.

They physical view of the filesystem can be useful for
troubleshooting and debugging. These view are exposed
within the view model as **fs** elements.
 